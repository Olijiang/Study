import Mock from "mockjs";

const baseurl = "http://localhost:8888";

function getAside(data) {
  // console.log(data.body);
  let type = data.body;
  if (type === "学生") {
    return {
      code: 200,
      data: [
        {
          index: "1",
          path: "Home",
          iconName: "HomeFilled",
          itemName: "首页",
        },
        {
          index: "2",
          path: "Student",
          iconName: "UserFilled",
          itemName: "学生信息",
        },
        {
          index: "5",
          iconName: "More",
          itemName: "更多功能",
          children: [
            {
              index: "5-1",
              iconName: "#",
              path: "PageOne",
              itemName: "功能一",
            },
            {
              index: "5-2",
              iconName: "#",
              path: "PageTwo",
              itemName: "功能二",
            },
          ],
        },
      ],
    };
  } else if (type === "教师") {
    return {
      code: 200,
      data: [
        {
          index: "1",
          path: "Home",
          iconName: "HomeFilled",
          itemName: "首页",
        },
        {
          index: "3",
          path: "Teacher",
          iconName: "Avatar",
          itemName: "教师信息",
        },
        {
          index: "5",
          iconName: "More",
          itemName: "更多功能",
          children: [
            {
              index: "5-1",
              iconName: "#",
              path: "PageOne",
              itemName: "功能一",
            },
            {
              index: "5-2",
              iconName: "#",
              path: "PageTwo",
              itemName: "功能二",
            },
          ],
        },
      ],
    };
  } else if (type === "管理员") {
    return {
      code: 200,
      data: [
        {
          index: "1",
          path: "Home",
          iconName: "HomeFilled",
          itemName: "首页",
        },
        {
          index: "2",
          path: "Student",
          iconName: "UserFilled",
          itemName: "学生信息",
        },
        {
          index: "3",
          path: "Teacher",
          iconName: "Avatar",
          itemName: "教师信息",
        },
        {
          index: "4",
          path: "User",
          iconName: "HelpFilled",
          itemName: "用户信息",
        },
        {
          index: "5",
          iconName: "More",
          itemName: "更多功能",
          children: [
            {
              index: "5-1",
              iconName: "#",
              path: "PageOne",
              itemName: "功能一",
            },
            {
              index: "5-2",
              iconName: "#",
              path: "PageTwo",
              itemName: "功能二",
            },
          ],
        },
      ],
    };
  } else {
    return {
      code: 200,
      data: [
        {
          index: "1",
          path: "Home",
          iconName: "HomeFilled",
          itemName: "首页",
        },
        {
          index: "5",
          iconName: "More",
          itemName: "更多功能",
          children: [
            {
              index: "5-1",
              iconName: "#",
              path: "PageOne",
              itemName: "功能一",
            },
            {
              index: "5-2",
              iconName: "#",
              path: "PageTwo",
              itemName: "功能二",
            },
          ],
        },
      ],
    };
  }
}
Mock.mock(baseurl + "/getAside", (data) => getAside(data));

function getStudents() {
  return {
    code: 200,
    apiSet: {
      add: "/student/add",
      delete: "/student/delete",
      update: "/student/update",
    },
    queryconfig: {
      tip1: "按ID查找", //placeholder
      tip2: "按姓名查找",
      attr1: "sid", //要查的属性
      attr2: "sname",
    },
    dialog: {
      type: "学生",
      data: [
        { lable: "学生ID", attr: "sid" },
        { lable: "姓名", attr: "sname" },
        { lable: "年龄", attr: "age" },
        { lable: "班级", attr: "cname" },
        { lable: "年级", attr: "grade" },
        { lable: "邮箱", attr: "email" },
        { lable: "电话", attr: "telephone" },
      ],
    },
    table: {
      header: [
        { index: "1", prop: "sid", lable: "学生ID", width: "150" },
        { index: "2", prop: "sname", lable: "姓名", width: "100" },
        { index: "3", prop: "age", lable: "年龄", width: "100" },
        { index: "4", prop: "cname", lable: "班级", width: "100" },
        { index: "5", prop: "grade", lable: "年级", width: "100" },
        { index: "6", prop: "email", lable: "邮箱", width: "200" },
        { index: "7", prop: "telephone", lable: "电话", width: "150" },
      ],
      data: [
        {
          age: 22,
          cname: "202",
          email: "20200001@qq.com",
          grade: 2,
          id: 1,
          sid: "20200001",
          sname: "梦洁",
          telephone: "20200001000",
        },
        {
          age: 21,
          cname: "201",
          email: "20200002@qq.com",
          grade: 2,
          id: 2,
          sid: "20200002",
          sname: "雅静",
          telephone: "20200002000",
        },
        {
          age: 21,
          cname: "101",
          email: "20200003@qq.com",
          grade: 1,
          id: 3,
          sid: "20200003",
          sname: "韵寒",
          telephone: "20200003000",
        },
        {
          age: 22,
          cname: "201",
          email: "20200004@qq.com",
          grade: 2,
          id: 4,
          sid: "20200004",
          sname: "莉姿",
          telephone: "20200004000",
        },
        {
          age: 20,
          cname: "201",
          email: "20200005@qq.com",
          grade: 2,
          id: 5,
          sid: "20200005",
          sname: "沛玲",
          telephone: "20200005000",
        },
        {
          age: 20,
          cname: "101",
          email: "20200006@qq.com",
          grade: 1,
          id: 6,
          sid: "20200006",
          sname: "欣妍",
          telephone: "20200006000",
        },
        {
          age: 22,
          cname: "102",
          email: "20200007@qq.com",
          grade: 1,
          id: 7,
          sid: "20200007",
          sname: "歆瑶",
          telephone: "20200007000",
        },
        {
          age: 20,
          cname: "202",
          email: "20200008@qq.com",
          grade: 2,
          id: 8,
          sid: "20200008",
          sname: "凌菲",
          telephone: "20200008000",
        },
        {
          age: 21,
          cname: "102",
          email: "20200009@qq.com",
          grade: 1,
          id: 9,
          sid: "20200009",
          sname: "靖瑶",
          telephone: "20200009000",
        },
        {
          age: 19,
          cname: "102",
          email: "20200010@qq.com",
          grade: 1,
          id: 10,
          sid: "20200010",
          sname: "瑾萱",
          telephone: "20200010000",
        },
        {
          age: 18,
          cname: "202",
          email: "20200011@qq.com",
          grade: 2,
          id: 11,
          sid: "20200011",
          sname: "月琪",
          telephone: "20200011000",
        },
        {
          age: 22,
          cname: "201",
          email: "20200012@qq.com",
          grade: 2,
          id: 12,
          sid: "20200012",
          sname: "瑾瑜",
          telephone: "20200012000",
        },
        {
          age: 22,
          cname: "202",
          email: "20200013@qq.com",
          grade: 2,
          id: 13,
          sid: "20200013",
          sname: "瑜昕",
          telephone: "20200013000",
        },
        {
          age: 22,
          cname: "101",
          email: "20200014@qq.com",
          grade: 1,
          id: 14,
          sid: "20200014",
          sname: "槿玥",
          telephone: "20200014000",
        },
        {
          age: 20,
          cname: "102",
          email: "20200015@qq.com",
          grade: 1,
          id: 15,
          sid: "20200015",
          sname: "菡初",
          telephone: "20200015000",
        },
        {
          age: 19,
          cname: "102",
          email: "20200016@qq.com",
          grade: 1,
          id: 16,
          sid: "20200016",
          sname: "妙桐",
          telephone: "20200016000",
        },
        {
          age: 22,
          cname: "101",
          email: "20200017@qq.com",
          grade: 1,
          id: 17,
          sid: "20200017",
          sname: "莹然",
          telephone: "20200017000",
        },
        {
          age: 21,
          cname: "102",
          email: "20200018@qq.com",
          grade: 1,
          id: 18,
          sid: "20200018",
          sname: "夕纯",
          telephone: "20200018000",
        },
        {
          age: 20,
          cname: "202",
          email: "20200019@qq.com",
          grade: 2,
          id: 19,
          sid: "20200019",
          sname: "思羽",
          telephone: "17396914413",
        },
        {
          age: 18,
          cname: "102",
          email: "20200020@qq.com",
          grade: 1,
          id: 20,
          sid: "20200020",
          sname: "溪瑶",
          telephone: "20200020000",
        },
        {
          age: 22,
          cname: "202",
          email: "20200021@qq.com",
          grade: 2,
          id: 21,
          sid: "20200021",
          sname: "羽慕",
          telephone: "20200021000",
        },
        {
          age: 19,
          cname: "201",
          email: "20200022@qq.com",
          grade: 2,
          id: 22,
          sid: "20200022",
          sname: "雨妍",
          telephone: "20200022000",
        },
        {
          age: 20,
          cname: "101",
          email: "20200023@qq.com",
          grade: 1,
          id: 23,
          sid: "20200023",
          sname: "瑾语",
          telephone: "20200023000",
        },
        {
          age: 22,
          cname: "201",
          email: "20200024@qq.com",
          grade: 2,
          id: 24,
          sid: "20200024",
          sname: "雅颍",
          telephone: "20200024000",
        },
        {
          age: 21,
          cname: "101",
          email: "20200025@qq.com",
          grade: 1,
          id: 25,
          sid: "20200025",
          sname: "馨安",
          telephone: "20200025000",
        },
        {
          age: 19,
          cname: "201",
          email: "20200026@qq.com",
          grade: 2,
          id: 26,
          sid: "20200026",
          sname: "锦汐",
          telephone: "20200026000",
        },
        {
          age: 22,
          cname: "102",
          email: "20200027@qq.com",
          grade: 1,
          id: 27,
          sid: "20200027",
          sname: "言希",
          telephone: "20200027000",
        },
      ],
    },
  };
}
Mock.mock(baseurl + "/student/get", getStudents);

Mock.mock(baseurl + "/student/add", (data) => {
  console.log("mock received add:", data.body);
  return {
    code: 200,
  };
});
Mock.mock(baseurl + "/student/delete", (data) => {
  console.log("mock received delete:", data.body);
  return {
    code: 200,
  };
});
Mock.mock(baseurl + "/student/update", (data) => {
  console.log("mock received update:", data.body);
  return {
    code: 200,
  };
});

function getTeachers() {
  return {
    code: 200,
    apiSet: {
      add: "/teacher/add",
      delete: "/teacher/delete",
      update: "/teacher/update",
    },
    queryconfig: {
      tip1: "按ID查找", //placeholder
      tip2: "按姓名查找",
      attr1: "tid", //要查的属性
      attr2: "tname",
    },
    dialog: {
      type: "教师",
      data: [
        { lable: "教师ID", attr: "tid" },
        { lable: "姓名", attr: "tname" },
        { lable: "年龄", attr: "age" },
        { lable: "班级", attr: "cname" },
        { lable: "邮箱", attr: "email" },
        { lable: "电话", attr: "telephone" },
      ],
    },
    table: {
      query1Tip: "按ID查找",
      query2Tip: "按姓名查找",
      header: [
        { index: "1", prop: "tid", lable: "教师ID", width: "150" },
        { index: "2", prop: "tname", lable: "姓名", width: "100" },
        { index: "3", prop: "age", lable: "年龄", width: "100" },
        { index: "4", prop: "cname", lable: "班级", width: "100" },
        { index: "5", prop: "email", lable: "邮箱", width: "200" },
        { index: "6", prop: "telephone", lable: "电话", width: "150" },
      ],
      data: [
        {
          age: 31,
          cname: "101",
          email: "20201001@qq.com",
          id: 1,
          telephone: "20201001000",
          tid: "20201001",
          tname: "安老师",
        },
        {
          age: 31,
          cname: "202",
          email: "20201002@qq.com",
          id: 2,
          telephone: "20201002000",
          tid: "20201002",
          tname: "徐老师",
        },
        {
          age: 30,
          cname: "102",
          email: "20201003@qq.com",
          id: 3,
          telephone: "20201003000",
          tid: "20201003",
          tname: "王老师",
        },
        {
          age: 29,
          cname: "201",
          email: "20201004@qq.com",
          id: 4,
          telephone: "20201004000",
          tid: "20201004",
          tname: "何老师",
        },
      ],
    },
  };
}
Mock.mock(baseurl + "/getTeachers", getTeachers);

Mock.mock(baseurl + "/teacher/add", (data) => {
  console.log("mock received:", data.body);
  return {
    code: 200,
  };
});
Mock.mock(baseurl + "/teacher/delete", (data) => {
  console.log("mock received:", data.body);
  return {
    code: 200,
  };
});
Mock.mock(baseurl + "/teacher/update", (data) => {
  console.log("mock received:", data.body);
  return {
    code: 200,
  };
});

function getUser() {
  let userData = [
    {
      credential: "12345",
      id: 1,
      identifier: "20200001@qq.com",
      loginType: "email",
      statusCode: 1,
      uid: "20200001",
    },
    {
      credential: "12345",
      id: 2,
      identifier: "20200001000",
      loginType: "telephone",
      statusCode: 1,
      uid: "20200001",
    },
    {
      credential: "12345",
      id: 3,
      identifier: "20200001",
      loginType: "id",
      statusCode: 1,
      uid: "20200001",
    },
    {
      credential: "12345",
      id: 4,
      identifier: "20200002@qq.com",
      loginType: "email",
      statusCode: 1,
      uid: "20200002",
    },
    {
      credential: "12345",
      id: 5,
      identifier: "20200002000",
      loginType: "telephone",
      statusCode: 1,
      uid: "20200002",
    },
    {
      credential: "12345",
      id: 6,
      identifier: "20200002",
      loginType: "id",
      statusCode: 1,
      uid: "20200002",
    },
    {
      credential: "12345",
      id: 7,
      identifier: "20200019@qq.com",
      loginType: "email",
      statusCode: 1,
      uid: "20200019",
    },
    {
      credential: "12345",
      id: 8,
      identifier: "17396914413",
      loginType: "telephone",
      statusCode: 1,
      uid: "20200019",
    },
    {
      credential: "12345",
      id: 9,
      identifier: "20200019",
      loginType: "id",
      statusCode: 1,
      uid: "20200019",
    },
    {
      credential: "1234",
      id: 10,
      identifier: "20201001@qq.com",
      loginType: "email",
      statusCode: 2,
      uid: "20201001",
    },
    {
      credential: "1234",
      id: 11,
      identifier: "20201001000",
      loginType: "telephone",
      statusCode: 2,
      uid: "20201001",
    },
    {
      credential: "1234",
      id: 12,
      identifier: "20201001",
      loginType: "id",
      statusCode: 2,
      uid: "20201001",
    },
    {
      credential: "1234",
      id: 13,
      identifier: "20201002@qq.com",
      loginType: "email",
      statusCode: 2,
      uid: "20201002",
    },
    {
      credential: "1234",
      id: 14,
      identifier: "20201002000",
      loginType: "telephone",
      statusCode: 2,
      uid: "20201002",
    },
    {
      credential: "1234",
      id: 15,
      identifier: "20201002",
      loginType: "id",
      statusCode: 2,
      uid: "20201002",
    },
    {
      credential: "1234",
      id: 16,
      identifier: "20201003@qq.com",
      loginType: "email",
      statusCode: 2,
      uid: "20201003",
    },
    {
      credential: "1234",
      id: 17,
      identifier: "20201003000",
      loginType: "telephone",
      statusCode: 2,
      uid: "20201003",
    },
    {
      credential: "1234",
      id: 18,
      identifier: "20201003",
      loginType: "id",
      statusCode: 2,
      uid: "20201003",
    },
    {
      credential: "8888",
      id: 19,
      identifier: "66668888",
      loginType: "id",
      statusCode: 0,
      uid: "66668888",
    },
    {
      credential: "1111",
      id: 20,
      identifier: "20200010@qq.com",
      loginType: "email",
      statusCode: 1,
      uid: "20200010",
    },
    {
      credential: "1111",
      id: 21,
      identifier: "20200010000",
      loginType: "telephone",
      statusCode: 1,
      uid: "20200010",
    },
    {
      credential: "1111",
      id: 22,
      identifier: "20200010",
      loginType: "id",
      statusCode: 1,
      uid: "20200010",
    },
  ];
  let statusMap = ["管理员", "学生", "教师"];

  for (let i = 0; i < userData.length; i++) {
    userData[i].statusCode = statusMap[eval(userData[i].statusCode)];
  }
  return {
    code: 200,
    apiSet: {
      add: "/user/add",
      delete: "/user/delete",
      update: "/user/update",
    },
    queryconfig: {
      tip1: "按ID查找", //placeholder
      tip2: "按登录账号查找",
      attr1: "uid", //要查的属性
      attr2: "identifier",
    },
    dialog: {
      type: "用户",
      data: [
        { lable: "用户ID", attr: "uid" },
        { lable: "登录账户", attr: "identifier" },
        { lable: "登录密码", attr: "credential" },
        { lable: "登录方式", attr: "loginType" },
        { lable: "身份", attr: "statusCode" },
      ],
    },
    table: {
      query1Tip: "按ID查找",
      query2Tip: "按登录账户查找",
      header: [
        { index: "1", prop: "uid", lable: "用户ID", width: "150" },
        { index: "2", prop: "identifier", lable: "登录账户", width: "200" },
        { index: "3", prop: "credential", lable: "登录密码", width: "100" },
        { index: "4", prop: "loginType", lable: "登录方式", width: "150" },
        { index: "5", prop: "statusCode", lable: "身份", width: "100" },
      ],
      data: userData,
    },
  };
}
Mock.mock(baseurl + "/getUser", getUser);

Mock.mock(baseurl + "/user/add", (data) => {
  console.log("mock received:", data.body);
  return {
    code: 200,
  };
});
Mock.mock(baseurl + "/user/delete", (data) => {
  console.log("mock received:", data.body);
  return {
    code: 200,
  };
});
Mock.mock(baseurl + "/user/update", (data) => {
  console.log("mock received:", data.body);
  return {
    code: 200,
  };
});

// Mock.mock(baseurl + "/login", (LoginData) => {
//   console.log("mock received login:", LoginData);

//   return {
//     uid: "12345",
//     userType: "管理员",
//     userName: "月儿",
//     code: 200,
//     message: "登录成功",
//     token: "1111111111111",
//   };
// });
