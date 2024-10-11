INSERT INTO user_db (user_id, first_name, last_name, password, email, phone_number, address_line1, address_line2, address_line3)
       VALUES (100, 'Default', 'user', '{bcrypt}$2a$10$EZYtZ/beE61i1lZ7WdETNeBqk.G5bEDT0QUr5srGLzQ66yCxAp69u', 'default@mail.com', '1234567890','test','test','test');


INSERT INTO role(role_id, user_id, description, role_names)
       VALUES(101, 100, 'Default role','ADMIN');
