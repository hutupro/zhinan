create table record (
    id int  auto increment primary key, -- 自增主键
    title varchar(100), -- 标题
    info varchar(500), -- 描述
    collection varchar(100), -- 集合
    category varchar(100), -- 分类
    link varchar(500), -- 链接地址
    tag varchar(100), -- 标签
    weight int, -- 权重，越大越靠前

);

create table collection(
    name varchar(100) primary key, --集合名称，主键
    info varchar(200), -- 集合描述，用于title显示
    weight int, --权重，越大显示越靠前
);

create table category(
    name varchar(100) primary key, --分类名称，主键
    collection_name varchar(100) primary key (collection_name, name)
    info varchar(200), -- 分类的描述
    weight int, --权重，越大显示越靠前
)