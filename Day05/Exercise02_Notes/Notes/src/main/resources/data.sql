insert into user (id, name, username, password) values(101, 'Elena Dimanoska', 'elena', 'elena');
insert into user (id, name, username, password) values(102, 'Petre Petreski', 'petre', 'petre');

insert into tag(id, name, user_id) values (101, 'FirstTag', 101);
insert into tag(id, name, user_id) values (102, 'SecondTag', 102);

insert into note(id, content, title, user_id) values (101, 'FirstContent', 'FirstNote', 101);
insert into note(id, content, title, user_id) values(102, 'SecondContent', 'SecondNote', 102);

insert into note_tags(notes_id,tags_id) values(101,101);
insert into note_tags(notes_id,tags_id) values(102,102);




