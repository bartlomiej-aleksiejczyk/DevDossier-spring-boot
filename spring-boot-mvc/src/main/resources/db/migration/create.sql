
    create sequence id_seq start with 1 increment by 1;

    create table apps (
        created_at timestamp(6) not null,
        created_by_id bigint,
        id bigint not null,
        modified_at timestamp(6),
        description varchar(255),
        repo_link varchar(255),
        primary key (id)
    );

    create table attachments (
        created_at timestamp(6) not null,
        created_by_id bigint,
        id bigint not null,
        modified_at timestamp(6),
        file_path varchar(255),
        type varchar(255),
        primary key (id)
    );

    create table comments (
        attachment_id bigint unique,
        created_at timestamp(6) not null,
        created_by_id bigint,
        entry_id bigint,
        id bigint not null,
        modified_at timestamp(6),
        body varchar(255),
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table entries (
        app_id bigint,
        created_at timestamp(6) not null,
        created_by_id bigint,
        id bigint not null,
        modified_at timestamp(6),
        description varchar(255),
        name varchar(255),
        priority varchar(255) check (priority in ('LOW','MEDIUM','HIGH','CRITICAL')),
        status varchar(255) check (status in ('NEW','IN_PROGRESS','COMPLETED','ARCHIVED')),
        type varchar(255) check (type in ('TYPE1','TYPE2','TYPE3')),
        primary key (id)
    );

    create table entry_tag (
        entry_id bigint not null,
        tag_id bigint not null,
        primary key (entry_id, tag_id)
    );

    create table tags (
        created_at timestamp(6) not null,
        id bigint not null,
        modified_at timestamp(6),
        description varchar(255),
        name varchar(255),
        tag_color varchar(255),
        primary key (id)
    );

    create table users (
        created_at timestamp(6) not null,
        id bigint not null,
        last_login timestamp(6),
        modified_at timestamp(6),
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists apps 
       add constraint FK8694pj7rntglnl8eav7syk3ej 
       foreign key (created_by_id) 
       references users;

    alter table if exists attachments 
       add constraint FKt7ran61vbwy22ya6qdcf4fjni 
       foreign key (created_by_id) 
       references users;

    alter table if exists comments 
       add constraint FK63xvaeljmval6cj58i0flhx8n 
       foreign key (attachment_id) 
       references attachments;

    alter table if exists comments 
       add constraint FKakkm6qfydu7vgnfne1yo0xmed 
       foreign key (created_by_id) 
       references users;

    alter table if exists comments 
       add constraint FKm0iyui5jbximncdqpivu66gvb 
       foreign key (entry_id) 
       references entries;

    alter table if exists entries 
       add constraint FK1v0nexw1yidnf3hdkupnn6y7a 
       foreign key (app_id) 
       references apps;

    alter table if exists entries 
       add constraint FK66e68fewilhvo5ogbwcdqv3dm 
       foreign key (created_by_id) 
       references users;

    alter table if exists entry_tag 
       add constraint FKb9cd94mf8bh7pwvkg7te78rqm 
       foreign key (entry_id) 
       references entries;

    alter table if exists entry_tag 
       add constraint FKdotiero875glmpckf056i7l81 
       foreign key (tag_id) 
       references tags;
