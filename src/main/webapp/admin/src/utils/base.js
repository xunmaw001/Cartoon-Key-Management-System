const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyuanyikatongmiyaoguanli/",
            name: "xiaoyuanyikatongmiyaoguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyuanyikatongmiyaoguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园一卡通密钥管理系统"
        } 
    }
}
export default base
