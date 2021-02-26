import React from 'react';
import PropTypes from 'prop-types';
import {ControlLabel} from 'react-bootstrap';
import lodash from 'lodash';

import {Input} from 'components/bootstrap';
import FormsUtils from 'util/FormsUtils';

class KafkaNotificationForm extends React.Component {
    static propTypes = {
        config: PropTypes.object.isRequired,
        validation: PropTypes.object.isRequired,
        onChange: PropTypes.func.isRequired,
    };

    static defaultConfig = {
        bootstrapServers: 'localhost:9092',
        topic: 'topic',
        content: 'kafka-send-content',
    };

    propagateChange = (key, value) => {
        const {config, onChange} = this.props;
        const nextConfig = lodash.cloneDeep(config);
        nextConfig[key] = value;
        onChange(nextConfig);
    };

    handleChange = event => {
        const {name} = event.target;
        this.propagateChange(name, FormsUtils.getValueFromInput(event.target));
    };

    render() {
        const {config, validation} = this.props;

        return (
            <React.Fragment>
                <ControlLabel>Bootstrap servers </ControlLabel>
                <Input
                    id="bootstrapServers"
                    type="text"
                    name="bootstrapServers"
                    help="This is servers url which you want to send kafka message"
                    value={config.bootstrapServers ? config.bootstrapServers : kafkaNConfig.bootstrapServers}
                    onChange={this.handleChange}
                />

                <ControlLabel>Topic </ControlLabel>
                <Input
                    id="topic"
                    type="text"
                    name="topic"
                    help="This is topic which you want to send kafka message"
                    value={config.topic ? config.topic : kafkaNConfig.topic}
                    onChange={this.handleChange}
                />

                <ControlLabel>Content </ControlLabel>
                <Input
                    id="content"
                    type="text"
                    name="content"
                    help="This is content which you want to send kafka message"
                    value={config.content ? config.content : kafkaNConfig.content}
                    onChange={this.handleChange}
                />
            </React.Fragment>
        );
    }
}

export default KafkaNotificationForm;