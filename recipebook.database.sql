CREATE SEQUENCE users_id;
CREATE TABLE users (id INTEGER DEFAULT NEXTVAL('users_id') primary key,
                    version integer default 1 not null,
                    email VARCHAR(64),
                    name VARCHAR(64),
                    passwd VARCHAR(64));
                    
CREATE SEQUENCE recipes_id;
CREATE TABLE recipes (id INTEGER DEFAULT NEXTVAL('recipes_id') primary key,
                      version integer default 1 not null,
                      user_id INTEGER REFERENCES users(id) ON DELETE CASCADE NOT NULL,
                      ingredients TEXT,
                      instructions TEXT,
                      added_on TIMESTAMP(0),
                      tags TEXT);
                    
CREATE SEQUENCE comments_id;
CREATE TABLE comments (id INTEGER DEFAULT NEXTVAL('comments_id') primary key,
                       version integer default 1 not null,
                       user_id INTEGER REFERENCES users(id) ON DELETE CASCADE NOT NULL,
                       recipe_id INTEGER REFERENCES recipes(id) ON DELETE CASCADE NOT NULL,
                       body TEXT,
                       rating INTEGER,
                       added_on TIMESTAMP(0));
                       
CREATE FUNCTION version_update() RETURNS TRIGGER AS $vup$
BEGIN
	NEW.version := :NEW.version + 1;
	
	RETURN NEW;
END;
$vup$ LANGUAGE 'plpgsql';

CREATE TRIGGER version_updater_users BEFORE UPDATE ON users
FOR EACH ROW EXECUTE PROCEDURE version_update();

CREATE TRIGGER version_updater_recipes BEFORE UPDATE ON recipes
FOR EACH ROW EXECUTE PROCEDURE version_update();

CREATE TRIGGER version_updater_comments BEFORE UPDATE ON comments
FOR EACH ROW EXECUTE PROCEDURE version_update();

COMMIT;                       
                    