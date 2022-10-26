import Mock from "mockjs";

const baseurl = "http://localhost:8080";


Mock.mock(baseurl + "/getAside", (data) => getAside(data));
