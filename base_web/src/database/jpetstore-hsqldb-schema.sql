-- drop index productCat;
-- drop index productName;
-- drop index itemProd;

-- drop table lineitem;
-- drop table orderstatus;
-- drop table orders;
-- drop table bannerdata;
-- drop table profile;
-- drop table signon;
-- drop table inventory;
-- drop table item;
-- drop table product;
-- drop table account;
-- drop table category;
-- drop table supplier;
-- drop table sequence;



create table account (
    account_id int not null,
	account_code varchar(80) not null,
	account_name varchar(80) not null,
	password varchar(25)  not null,
	company_id integer not null,
	dept_id integer not null,
    email varchar(80) not null,
    status varchar(2)  null,
    addr1 varchar(80) not null,
    addr2 varchar(40) null,
	phone varchar(80) not null,
    constraint pk_account primary key (account_id)
);

CREATE TABLE ACCOUNT_ROLE
 (ACCOUNT_ROLE_ID           int  NOT NULL  DEFAULT -1,
  ACCOUNT_ID            int  NOT NULL  DEFAULT -1,
  ROLE_ID          INT  NOT NULL  DEFAULT -1
 )
 
 CREATE TABLE ROLE(
  ROLE_ID INT NOT NULL,
  ROLE_CODE VARCHAR(80) NOT NULL,
  ROLE_NAME VARCHAR(200) NOT NULL
  )

CREATE TABLE ROLE_MENU(
   ROLE_MENU_ID INT NOT NULL,
   ROLE_ID INT NOT NULL,
   MENU_ID INT NOT NULL
  )
  
CREATE TABLE MENU(
   MENU_ID INT NOT NULL,
   MENU_CODE VARCHAR(80) NOT NULL,
   MENU_NAME VARCHAR(200) NOT NULL,
   MENU_URL VARCHAR(400) ,
   MENU_PICTURE VARCHAR(400) , 
   MENU_PARENT_ID INT ,
   MENU_LEVEL INT 
  )
  
create table dept (
	dept_id integer not null,
	dept_code varchar(80) not null,
	dept_name varchar(200) not null,
	COMPANY_ID INT 
)

CREATE TABLE COMPANY(
	COMPANY_ID INT NOT NULL,
	COMPANY_CODE VARCHAR(80) NOT NULL,
	COMPANY_NAME VARCHAR(200) NOT NULL
)

create table profile (
    userid varchar(80) not null,
    langpref varchar(80) not null,
    favcategory varchar(30),
    mylistopt int,
    banneropt int,
    constraint pk_profile primary key (userid)
);

create table bannerdata (
    favcategory varchar(80) not null,
    bannername varchar(255)  null,
    constraint pk_bannerdata primary key (favcategory)
);

create table orders (
      orderid int not null,
      userid varchar(80) not null,
      orderdate date not null,
      shipaddr1 varchar(80) not null,
      shipaddr2 varchar(80) null,
      shipcity varchar(80) not null,
      shipstate varchar(80) not null,
      shipzip varchar(20) not null,
      shipcountry varchar(20) not null,
      billaddr1 varchar(80) not null,
      billaddr2 varchar(80)  null,
      billcity varchar(80) not null,
      billstate varchar(80) not null,
      billzip varchar(20) not null,
      billcountry varchar(20) not null,
      courier varchar(80) not null,
      totalprice decimal(10,2) not null,
      billtofirstname varchar(80) not null,
      billtolastname varchar(80) not null,
      shiptofirstname varchar(80) not null,
      shiptolastname varchar(80) not null,
      creditcard varchar(80) not null,
      exprdate varchar(7) not null,
      cardtype varchar(80) not null,
      locale varchar(80) not null,
      constraint pk_orders primary key (orderid)
);

create table orderstatus (
      orderid int not null,
      linenum int not null,
      timestamp date not null,
      status varchar(2) not null,
      constraint pk_orderstatus primary key (orderid, linenum)
);

create table lineitem (
      orderid int not null,
      linenum int not null,
      itemid varchar(10) not null,
      quantity int not null,
      unitprice decimal(10,2) not null,
      constraint pk_lineitem primary key (orderid, linenum)
);

create table category (
	catid varchar(10) not null,
	name varchar(80) null,
	descn varchar(255) null,
	constraint pk_category primary key (catid)
);

create table product (
    productid varchar(10) not null,
    category varchar(10) not null,
    name varchar(80) null,
    descn varchar(255) null,
    constraint pk_product primary key (productid),
        constraint fk_product_1 foreign key (category)
        references category (catid)
);

create index productCat on product (category);
create index productName on product (name);

create table item (
    itemid varchar(10) not null,
    productid varchar(10) not null,
    listprice decimal(10,2) null,
    unitcost decimal(10,2) null,
    supplier int null,
    status varchar(2) null,
    attr1 varchar(80) null,
    attr2 varchar(80) null,
    attr3 varchar(80) null,
    attr4 varchar(80) null,
    attr5 varchar(80) null,
    constraint pk_item primary key (itemid),
        constraint fk_item_1 foreign key (productid)
        references product (productid),
        constraint fk_item_2 foreign key (supplier)
        references supplier (suppid)
);

create index itemProd on item (productid);

create table inventory (
    itemid varchar(10) not null,
    qty int not null,
    constraint pk_inventory primary key (itemid)
);

CREATE TABLE sequence
(
    name               varchar(30)  not null,
    nextid             int          not null,
    constraint pk_sequence primary key (name)
);
