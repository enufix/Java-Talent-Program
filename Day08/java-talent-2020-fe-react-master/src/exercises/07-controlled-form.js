import React, {Component} from 'react';
// For controlled components, the idea is that you push the values from the component
// to the consumer via callback handlers. In the context of a form, this is normally
// via `onChange` which receives the `event` (and you can get the value via
// `event.target.value`) like so:
//
//     <input onChange={event => console.log(event.target.value)} />
//
// In this scenario, you also need to provide the value for the input like so:
//
//     <input value={this.state.value} />
//
// This gives you a lot more power over the input.

// Exercise:
//   Render a EditNote form with an onSubmit handler that alerts the value of both title and content
//   while saving their data in the local component state
//   The submit button needs to be disabled if there is an error.
//   Error message needs to be displayed when:
//     - The title is empty - "Title is a mandatory field"
//     - The content is empty - "Content is a mandatory field"
//     - The title contains more than 10 characters - "Title cannot contain more than 10 characters"
//   Since this is a EditNote functionality, we need to make sure to display the 'Default Title' and 'Default Content'
//   when our component is rendered.
class EditNoteForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            title: this.props.defaultTitle,
            content: this.props.defaultContent,
            titleErrorMessage: "",
            contentErrorMessage: ""
        };
    }

    handleChangeTitle = (event) => {
        this.setState({title: event.target.value});
        if (event.target.value === "") {
            this.setState({titleErrorMessage: "Title is a mandatory field"});
        } else if (event.target.value.length > 10) {
            this.setState({titleErrorMessage: "Title cannot contain more than 10 characters"});
        }
    }
    handleChangeContent = (event) => {
        this.setState({content: event.target.value});
        if (event.target.value === "") {
            this.setState({contentErrorMessage: "Content is a mandatory field"});
        }
    }
    handleSubmit = () => {
        alert(this.state.title);
        alert(this.state.content);
    }

    render() {
        return <div>
            <form onSubmit={this.handleSubmit}>
                <label>Title: </label><input name="title" value={this.state.title} onChange={this.handleChangeTitle}/>
                <p>{this.state.titleErrorMessage}</p>
                <label>Content: </label><input name="content" value={this.state.content} onChange={this.handleChangeContent}/>
                <p>{this.state.contentErrorMessage}</p>
                <button type="submit" disabled={this.state.title === "" || this.state.content === "" || this.state.title.length > 10}>Submit</button>
            </form>
        </div>;
    }
}

export const Example = () => <EditNoteForm defaultTitle="Default title" defaultContent="Default Content"/>;