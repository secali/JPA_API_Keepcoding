
create table if not exists pet (
  id varchar(4) not null identity,
  nombre varchar(10),
  fechanacimiento Date,
  raza varchar(50),
  peso float(10),
  chipsi numeric(1)
);
