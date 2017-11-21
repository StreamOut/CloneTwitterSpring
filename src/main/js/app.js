const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {messages: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api', params : {action: 'list'}}).done(response => {
			console.log(response.entity.messages);
			this.setState({messages: response.entity.messages});
			
		});
	}

	render() {
		return (
			<MessageList messages={this.state.messages}/>
		)
	}
}

class MessageList extends React.Component{
	render() {
		var messages = this.props.messages.map(message => <Message key={message.id} message={message}/>);
		return (
			<table>
				<tbody>
					<tr>
						<th>Auteur</th>
						<th>Contenu</th>
						<th>Date</th>
					</tr>
					{messages}
				</tbody>
			</table>
		)
	}
}

class Message extends React.Component{
	render() {
		console.log(this.props);
		return (
			<tr>
				<td>{this.props.message.auteur}</td>
				<td>{this.props.message.contenu}</td>
				<td>{this.props.message.date}</td>
			</tr>
		)
	}
}

ReactDOM.render(
		<App />,
		document.getElementById('react')
	)
