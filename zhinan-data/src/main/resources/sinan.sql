create table record (
    id int  auto increment primary key, -- 自增主键
    title varchar(100), -- 标题
    info varchar(500), -- 描述
    collection varchar(100), -- 集合
    category varchar(100), -- 分类
    link varchar(500), -- 链接地址
    tag varchar(100), -- 标签
    weight int, -- 权重，越大越靠前

)