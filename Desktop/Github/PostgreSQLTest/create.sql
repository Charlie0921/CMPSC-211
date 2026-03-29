CREATE TABLE projects (
    project_id SERIAL PRIMARY KEY,
    project_title VARCHAR(255) NOT NULL,
    project_date DATE NOT NULL,
    project_description VARCHAR(255) NOT NULL,
    project_skills VARCHAR(255) NOT NULL,
    project_members INTEGER NULL,
    project_position VARCHAR(255) NULL,
    project_github VARCHAR(255) NULL,
    project_website VARCHAR(255) NULL,
    project_details VARCHAR(255) NULL,
    project_image VARCHAR(255) NULL
);