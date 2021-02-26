# graylog-plugin-kafka-notification

* [中文版](./README_CN.md)

Add a kafka notification to send kafka messages if you have a log that meets the rules


# KafkaNotification Plugin for Graylog

**Required Graylog version:** 4.0.1 and later

Installation
------------

[Download the plugin](https://github.com/qingmg/graylog-plugin-kafka-notification/releases)
and place the `.jar` file in your Graylog plugin directory. The plugin directory
is the `plugins/` folder relative from your `graylog-server` directory by default
and can be configured in your `graylog.conf` file.

Restart `graylog-server` and you are done.

Development
-----------

You can improve your development experience for the web interface part of your plugin
dramatically by making use of hot reloading. To do this, do the following:

* `git clone https://github.com/qingmg/graylog-plugin-kafka-notification.git`
* `git clone https://github.com/Graylog2/graylog2-server.git`
* `cd graylog2-server/graylog2-web-interface/packages/graylog-web-plugin`
* `yarn install`
* `cd ../../`
* `sed -i 's/127.0.0.1/<your graylog ip>/' config.js`
* `npm install && npm start`

__If there is an error with a code like `the network is offline, Origin is not allowed by Access-Control-Allow-Origin`, you need to turn on the cros configuration of graylog__

* Enter the machine where you installed graylog
* `cd $GRAYLOG_HOME/data/config`
* `vim graylog.conf`
    * `http_enable_cors = true`

Usage
-----

Alerts - Notifications - Create

Select the value of Notification Type as Kafka Notification