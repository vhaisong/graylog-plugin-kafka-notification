import React from 'react';
import PropTypes from 'prop-types';

import CommonNotificationSummary from "./CommonNotificationSummary";

class KafkaNotificationSummary extends React.Component {
    static propTypes = {
        type: PropTypes.string.isRequired,
        notification: PropTypes.object,
        definitionNotification: PropTypes.object.isRequired,
    };

    static defaultProps = {
        notification: {},
    };

    render() {
        const {notification} = this.props;
        return (
            <CommonNotificationSummary {...this.props}>
                <React.Fragment>
                    <tr>
                        <td>Bootstrap servers:</td>
                        <td>{notification.config.bootstrapServers}</td>
                    </tr>
                    <tr>
                        <td>Topic:</td>
                        <td>{notification.config.topic}</td>
                    </tr>
                    <tr>
                        <td>content:</td>
                        <td>{notification.config.content}</td>
                    </tr>
                </React.Fragment>
            </CommonNotificationSummary>
        );
    }
}

export default KafkaNotificationSummary;
