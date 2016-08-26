drop table dividend_f if exists;

                        
create table dividend_f (id bigint identity primary key, 
symbol varchar(9),
year int,
amount decimal(8,2));
               
ALTER TABLE dividend_f ALTER COLUMN amount SET DEFAULT 0.0;
