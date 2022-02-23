# sublime编译运行c语言后中文乱码的解决

tools>Build System>New Build System中写入
MinGW的bin目录加入环境目录
{
 "cmd": ["gcc", "${file}", "-fexec-charset=gbk","-o", "${file_path}/${file_base_name}", "&", "start", "cmd", "/c", "${file_base_name} & echo. & pause"],
 "file_regex": "^(..[^:]*):([0-9]+):?([0-9]+)?:? (.*)$",
 "working_dir": "${file_path}",
 "selector": "source.c, source.c++",
 "shell": true,
 "encoding":"cp936",
}


# 修改vscode  Code runner 的配置，使exe生成到指定文件夹 
"c": "cd $dir && gcc $fileName -D LOCAL -o D:\\Study\\C\\Practice\\exe\\$fileNameWithoutExt.exe && D:\\Study\\C\\Practice\\exe\\$fileNameWithoutExt.exe"

