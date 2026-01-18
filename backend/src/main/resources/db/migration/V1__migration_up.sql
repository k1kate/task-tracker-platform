CREATE TABLE IF NOT EXISTS  organization (
      uuid TEXT PRIMARY KEY,
      organization_name VARCHAR(255) NOT NULL,
      setup_complete BOOLEAN NOT NULL DEFAULT FALSE,
      created_at TIMESTAMP DEFAULT NOW(),
      updated_at TIMESTAMP DEFAULT NOW()
);
CREATE INDEX IF NOT EXISTS idx_org_name ON organization(organization_name);

CREATE TABLE IF NOT EXISTS unit(
     uuid TEXT PRIMARY KEY,
     unit_name VARCHAR(255) NOT NULL,
     organization_id TEXT NOT NULL,
     CONSTRAINT fk_organisation foreign key (organization_id) references organization(uuid)
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
      CONSTRAINT fk_unit FOREIGN KEY(unit_id) references unit(uuid)
);
CREATE INDEX IF NOT EXISTS idx_employee_name on employee(name);
CREATE INDEX IF NOT EXISTS idx_employee_second_name on employee(second_name);
CREATE INDEX IF NOT EXISTS idx_employee_email on employee(email);

CREATE TABLE IF NOT EXISTS  task_status(
      uuid TEXT PRIMARY KEY,
      status_name Varchar(255)
);
CREATE INDEX IF NOT EXISTS idx_task_status_name on task_status(status_name);

CREATE TABLE IF NOT EXISTS additional(
    uuid TEXT PRIMARY KEY,
    data JSONB
);

CREATE TABLE IF NOT EXISTS task(
    uuid TEXT PRIMARY KEY,
    task_name varchar(400),
    task_description TEXT,
    task_status  TEXT,
    estimated_time TIME,
    time_actually_spent TIME,
    responsible    TEXT,
    additional_settings TEXT,
    CONSTRAINT fk_responsible FOREIGN KEY(responsible) references employee(uuid),
    CONSTRAINT fk_status FOREIGN KEY(task_status) references task_status(uuid),
    CONSTRAINT fk_additional FOREIGN KEY(additional_settings) references additional(uuid)
);
CREATE INDEX IF NOT EXISTS idx_task_name on task(task_name);

CREATE TABLE IF NOT EXISTS type_of_work(
  uuid TEXT PRIMARY KEY,
  work_name Varchar(255)
);
CREATE INDEX IF NOT EXISTS idx_type_of_worK_name on type_of_work(work_name);

CREATE TABLE IF NOT EXISTS time_track(
    uuid TEXT PRIMARY KEY,
    time_spent time NOT NULL,
    comment    TEXT,
    type_of_work TEXT,
    employee_id TEXT,
    task_id TEXT,
    CONSTRAINT fk_employee_track FOREIGN KEY(employee_id) references employee(uuid),
    CONSTRAINT fk_task_track     FOREIGN KEY(task_id)     references task(uuid),
    CONSTRAINT fk_type_of_work   FOREIGN KEY(type_of_work) references type_of_work(uuid)
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
    CONSTRAINT fk_employee FOREIGN KEY(employee_id) references employee(uuid),
    CONSTRAINT fk_task     FOREIGN KEY(task_id) references task(uuid)
);

CREATE TABLE IF NOT EXISTS sprint(
    uuid TEXT PRIMARY KEY,
    unit_id TEXT,
    sprint_start timestamp,
    sprint_end   timestamp,
    CONSTRAINT fk_unit_sprint FOREIGN KEY(unit_id) references unit(uuid)
);

CREATE TABLE IF NOT EXISTS meeting(
    uuid TEXT PRIMARY KEY,
    time time,
    date date,
    daily bool default false,
    meeting_header TEXT,
    meeting_owner  TEXT,
    meeting_description TEXT,
    CONSTRAINT fk_employee FOREIGN KEY(meeting_owner) references employee(uuid)
);

CREATE TABLE IF NOT EXISTS invited(
    meeting_id TEXT,
    employee_id TEXT,
    PRIMARY KEY(meeting_id,employee_id),
    CONSTRAINT fk_meeting_id FOREIGN KEY(meeting_id) references meeting(uuid),
    CONSTRAINT fk_employee_id FOREIGN KEY(employee_id) references employee(uuid)
);



