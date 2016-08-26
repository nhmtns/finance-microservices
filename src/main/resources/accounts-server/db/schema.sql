drop table account if exists;
                        
create table account (id bigint identity primary key, 
account_number varchar(9),
name varchar(50) not null, 
description varchar(250),
account_type varchar(15),
purpose varchar(25),
taxdeferred boolean,
institution_name varchar(100),
owner_id bigint,
closed boolean,
closed_on date,
opened_on date,
hide boolean,
cash_balance decimal(8,2),
unique(account_number));

                        
ALTER TABLE account ALTER COLUMN cash_balance SET DEFAULT 0.0;
