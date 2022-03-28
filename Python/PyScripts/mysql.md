## 权限
- 权限授予
- 语法：`Grant <权限> on <表名[列名]> to 用户 with grant option`
    - 例1：`Grant select on users to use1 with grant option`
    - 例2: `Grant select on users[name] to use1 with grant option`

- 权限回收
- 语法：`revoke <权限> on <表名[列名]> from 用户 cascade`
    - 例1：`revoke select on users from use1 cascade`
    - 例2: `revoke select on users[name] from use1 cascade`

## 角色
- 角色创建：`create role <角色名>`
- 角色授权：`Grant <权限> on <表名[列名]> to <角色>`
- 权限回收：`revoke <权限> on <表名[列名]> from <角色>`
