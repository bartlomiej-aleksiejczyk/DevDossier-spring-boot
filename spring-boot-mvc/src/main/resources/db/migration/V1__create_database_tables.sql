CREATE SEQUENCE if NOT EXISTS public.id_seq AS BIGINT START WITH 1000;

create table public.users
(
    created_at  TIMESTAMP WITH TIME ZONE not null,
    id          BIGINT       NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
    last_login  TIMESTAMP WITH TIME ZONE,
    modified_at TIMESTAMP WITH TIME ZONE,
    description VARCHAR(255),
    name        VARCHAR(255)
);
create table public.apps
(
    created_at    TIMESTAMP WITH TIME ZONE not null,
    created_by_id BIGINT,
    id            BIGINT       NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
    modified_at   TIMESTAMP WITH TIME ZONE,
    description   VARCHAR(255),
    repo_link     VARCHAR(255),
    CONSTRAINT fk_app_user FOREIGN KEY (created_by_id) REFERENCES public.users (id)
);
create table public.attachments
(
    created_at    TIMESTAMP WITH TIME ZONE not null,
    created_by_id BIGINT,
    id            BIGINT                   NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
    modified_at   TIMESTAMP WITH TIME ZONE,
    file_path     VARCHAR(255),
    type          VARCHAR(255),
    CONSTRAINT fk_attachment_user FOREIGN KEY (created_by_id) REFERENCES public.users (id)
);
create table public.entries
(
    app_id        BIGINT,
    created_at    TIMESTAMP WITH TIME ZONE not null,
    created_by_id BIGINT,
    id            BIGINT                   NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
    modified_at   TIMESTAMP WITH TIME ZONE,
    description   VARCHAR(255),
    name          VARCHAR(255),
    priority      VARCHAR(255) check (priority in ('LOW', 'MEDIUM', 'HIGH', 'CRITICAL')),
    status        VARCHAR(255) check (status in ('NEW', 'IN_PROGRESS', 'COMPLETED', 'ARCHIVED')),
    type          VARCHAR(255) check (type in ('TYPE1', 'TYPE2', 'TYPE3')),
    CONSTRAINT fk_entry_app FOREIGN KEY (app_id) REFERENCES public.apps (id),
    CONSTRAINT fk_entry_user FOREIGN KEY (created_by_id) REFERENCES public.users (id)
);
create table public.comments
(
    attachment_id BIGINT unique,
    created_at    TIMESTAMP WITH TIME ZONE not null,
    created_by_id BIGINT,
    entry_id      BIGINT,
    id            BIGINT                   NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
    modified_at   TIMESTAMP WITH TIME ZONE,
    body          VARCHAR(255),
    description   VARCHAR(255),
    name          VARCHAR(255),
    CONSTRAINT fk_comment_attachment FOREIGN KEY (attachment_id) REFERENCES public.attachments (id),
    CONSTRAINT fk_comment_user FOREIGN KEY (created_by_id) REFERENCES public.users (id),
    CONSTRAINT fk_comment_entry FOREIGN KEY (entry_id) REFERENCES public.entries (id)
);
create table public.tags
(
    created_at  timestamp(6) not null,
    id          BIGINT       NOT NULL DEFAULT nextval('id_seq') PRIMARY KEY,
    modified_at TIMESTAMP WITH TIME ZONE,
    description VARCHAR(255),
    name        VARCHAR(255),
    tag_color   VARCHAR(255)
);
create table public.entry_tag
(
    entry_id BIGINT not null,
    tag_id   BIGINT not null,
    primary key (entry_id, tag_id),
    CONSTRAINT fk_entry_tag_entry FOREIGN KEY (entry_id) REFERENCES public.entries (id),
    CONSTRAINT fk_entry_tag_tag FOREIGN KEY (tag_id) REFERENCES public.tags (id)
);

