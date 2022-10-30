/**
 * @author hutupro
 * @since 2022/10/6
 */

const fs = require("fs");
const path = require("path");
const Mock = require("mockjs"); //mockjs 导入依赖模块
const JSON5 = require("json5"); //json5的作用是可以解析json文件中的注释
//读取json文件
function getJsonFile(filePath) {
    //读取指定json文件
    var json = fs.readFileSync(path.resolve(__dirname, filePath), "utf-8");
    //解析并返回
    return JSON5.parse(json);
}

//返回一个函数
module.exports = function (devServer) {
    if (process.env.MOCK === "true") {
        devServer.app.get("/record/getall", function (rep, res) {
            var json = getJsonFile("./records.json");
            res.json(Mock.mock(json));
        });

        devServer.app.get("/record/get-all-collect", function (rep, res) {
            var json = getJsonFile("./records-by-collect.json");
            res.json(Mock.mock(json));
        });

        devServer.app.get("/category/all-collect", function (rep, res) {
            var json = getJsonFile("./categories.json");
            res.json(Mock.mock(json));
        });


        devServer.app.get("/collection/all", function (rep, res) {
            var json = getJsonFile("./admin/collections.json");
            res.json(Mock.mock(json));
        });
        devServer.app.get("/collection/delete", function (rep, res) {
            print("collection/delete", rep);
            res.json(Mock.mock(JSON5.parse('{"code": 0, message: ""}')));
        });
        devServer.app.post("/collection/save", function (rep, res) {
            print("collection/save", rep);
            res.json(Mock.mock(JSON5.parse('{"code": 1, message: ""}')));
        });
    }
};

function print(url, request) {
    console.log("request url:[" + url + "], request:[query]:" + JSON.stringify(request['query']) +
        ", [params]:" + JSON.stringify(request['params']) +
        ", [data]:" + JSON.stringify(request['data']))
}