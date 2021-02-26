import 'webpack-entry';

import {PluginManifest, PluginStore} from 'graylog-web-plugin/plugin';

import packageJson from '../../package.json';

import KafkaNotificationForm from "./components/KafkaNotificationForm";
import KafkaNotificationSummary from "./components/KafkaNotificationSummary";

const manifest = new PluginManifest(packageJson, {
    /* This is the place where you define which entities you are providing to the web interface.
       Right now you can add routes and navigation elements to it.

       Examples: */

    // Adding a route to /sample, rendering YourReactComponent when called:

    // routes: [
    //  { path: '/sample', component: YourReactComponent, permissions: 'inputs:create' },
    // ],

    // Adding an element to the top navigation pointing to /sample named "Sample":

    // navigation: [
    //  { path: '/sample', description: 'Sample' },
    // ]
    eventNotificationTypes: [
        {
            type: 'kafka-notification-v1',
            displayName: 'KAFKA NOTIFICATION',
            formComponent: KafkaNotificationForm,
            summaryComponent: KafkaNotificationSummary,
            defaultConfig: KafkaNotificationForm.defaultConfig,
        }
    ]
});

PluginStore.register(manifest);
