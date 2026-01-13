CREATE TABLE IF NOT EXISTS  organization (
      uuid TEXT PRIMARY KEY,
      organization_name VARCHAR(255) NOT NULL,
      setup_complete BOOLEAN NOT NULL DEFAULT FALSE,
      created_at TIMESTAMP DEFAULT NOW(),
      updated_at TIMESTAMP DEFAULT NOW(),
);
CREATE INDEX IF NOT EXISTS idx_org_name ON organization(organization_name);

CREATE TABLE IF NOT EXISTS unit(
     uuid TEXT PRIMARY KEY,
     unit_name VARCHAR(255) NOT NULL,
     organization_id TEXT NOT NULL,
     ADD CONSTRAINT fk_organisation foreign key (organization_id) references organization(uuid)
);
CREATE INDEX IF NOT EXISTS idx_unit_name on unit(unit_name);

CREATE TABLE IF NOT EXISTS employee(
      uuid TEXT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      second_name VARCHAR(255) NOT NULL,
      patronymic  VARCHAR(255),
      employee_sprint_time_capacity time,
      avatar      TEXT,
      unit_id     TEXT NOT NULL,
      password    TEXT NOT NULL,
      email       varchar(255) NOT NULL,
      ADD CONSTRAINT fk_unit FOREIGN KEY(unit_id) references unit(uuid)
);
CREATE INDEX IF NOT EXISTS idx_employee_name on employee(name);
CREATE INDEX IF NOT EXISTS idx_employee_second_name on employee(second_name);
CREATE INDEX IF NOT EXISTS idx_employee_email on employee(email);

---будем добавлять через админку "ALTER TYPE enum_name ADD VALUE 'new_value'"
CREATE TYPE IF NOT EXISTS status as enum();

CREATE TABLE IF NOT EXISTS task(
    uuid TEXT PRIMARY KEY,
    task_name varchar(400),
    task_description TEXT,
    task_status status,
    estimated_time TIME,
    time_actually_spent TIME,
    responsible    TEXT,
    ADD CONSTRAINT fk_responsible FOREIGN KEY(responsible) references employee(uuid)
);
CREATE INDEX IF NOT EXISTS idx_task_name on task(task_name);

CREATE TABLE IF NOT EXISTS time_track(
    uuid TEXT PRIMARY KEY,
    time_spent time NOT NULL,
    comment    TEXT,
    type_of_work status,
    employee_id TEXT,
    task_id TEXT,
    ADD CONSTRAINT fk_employee_track FOREIGN KEY(employee_id) references employee(uuid),
    ADD CONSTRAINT fk_task_track     FOREIGN KEY(task_id)     references task(uuid)
);

CREATE TABLE IF NOT EXISTS commentaries(
    uuid TEXT PRIMARY KEY,
    text Text,
    pic  Text,
    employee_id TEXT,
    task_id TEXT,
    bot_comment bool DEFAULT false,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    ADD CONSTRAINT fk_employee FOREIGN KEY(employee_id) references employee(uuid),
    ADD CONSTRAINT fk_task     FOREIGN KEY(task_id) references task(uuid)
);

CREATE TABLE IF NOT EXISTS sprint(
    uuid TEXT PRIMARY KEY,
    unit_id TEXT,
    sprint_start timestamp,
    sprint_end   timestamp,
    ADD CONSTRAINT fk_unit_sprint FOREIGN KEY(unit_id) references unit(uuid);
);





