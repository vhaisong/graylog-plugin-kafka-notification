# graylog-plugin-kafka-notification

* [英文版](./README.md)

增加一个 kafka notification，实现拥有符合规则的日志则发送 kafka 消息


# KafkaNotification Plugin for Graylog

**需要 Graylog 的版本大于等于** 4.0.1 

安装
------------

[下载插件](https://github.com/qingmg/graylog-plugin-kafka-notification/releases) 并将 `.jar` 文件放置在 Graylog 插件目录中。默认情况下，plugin目录是相对于您的 `graylog-server` 目录的 `plugins/` 文件夹，可以在您的 `graylog.conf` 文件中进行配置。

重启 `graylog-server` 即可。

开发
-----------

您可以通过本地开发改善插件的 Web 界面部分的使用体验。为此，请执行以下操作：

* `git clone https://github.com/qingmg/graylog-plugin-kafka-notification.git`
* `git clone https://github.com/Graylog2/graylog2-server.git`
* `cd graylog2-server/graylog2-web-interface/packages/graylog-web-plugin`
* `yarn install`
* `cd ../../`
* `sed -i 's/127.0.0.1/<your graylog ip>/' config.js`
* `npm install && npm start`

__如果出现错误提示为: `the network is offline, Origin is not allowed by Access-Control-Allow-Origin`, 你需要参考以下操作完成 `graylog` 的 `cros` 配置。__

* 进入你装了 graylog 的服务器
* `cd $GRAYLOG_HOME/data/config`
* `vim graylog.conf`
    * `http_enable_cors = true`

使用
-----

依次进入 Alerts - Notifications - Create

将 Notification Type 选择 Kafka Notification