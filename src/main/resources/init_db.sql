CREATE DATABASE demo_app;

CREATE TABLE tbl_user (
    id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tbl_todo_list (
    id INT PRIMARY KEY IDENTITY(1,1),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date DATE,
    priority INT DEFAULT 1,
    is_completed TINYINT DEFAULT 0,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES tbl_user(id)
);

INSERT INTO tbl_user (name) VALUES ('John Doe');
INSERT INTO tbl_user (name) VALUES ('Jane Smith');
INSERT INTO tbl_user (name) VALUES ('Robert Johnson');
INSERT INTO tbl_user (name) VALUES ('Emily Davis');
INSERT INTO tbl_user (name) VALUES ('Michael Wilson');

INSERT INTO tbl_todo_list (title, description, due_date, priority, is_completed, user_id) VALUES
    ('Task 1', 'Description for Task 1', '2023-09-25', 1, 0, 1),
    ('Task 2', 'Description for Task 2', '2023-09-26', 2, 1, 1),
    ('Task 3', 'Description for Task 3', '2023-09-27', 3, 0, 1),
    ('Task 4', 'Description for Task 4', '2023-09-28', 1, 0, 1),
    ('Task 5', 'Description for Task 5', '2023-09-29', 2, 1, 1),
    ('Task A', 'Description for Task A', '2023-09-25', 1, 0, 2),
    ('Task B', 'Description for Task B', '2023-09-26', 2, 1, 2),
    ('Task C', 'Description for Task C', '2023-09-27', 3, 0, 2),
    ('Task D', 'Description for Task D', '2023-09-28', 1, 0, 2),
    ('Task E', 'Description for Task E', '2023-09-29', 2, 1, 2);
