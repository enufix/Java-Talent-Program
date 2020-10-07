import React, { Component } from 'react';
import axios from 'axios';
class Note extends Component {

  constructor(props) {
    super(props);
    this.state = {
      title: '',
      content: '',
      tags:[],
      tagsToAdd: []
    }
  }

  componentDidMount() {
    axios.get(`/api/tags`).then((res) => {
      console.log(res);
      this.setState({ tags: res.data });
    });
  }

  onSubmit(e) {
    e.preventDefault();
    const formData = {
      title: this.title.value,
      content: this.content.value
    };
    this.props.submitNote(formData, this.props.note.id);
    this.props.submitNote(formData, this.props.note.title);
    this.props.submitNote(formData, this.props.note.content);
  }

  onTagSubmit(e) {
    e.preventDefault();
    const formData = {
      name: this.name.value
    }
    this.props.submitTag(formData, this.props.note.id)
    this.props.closeTagForm();
  }

  renderTagForm(note) {
    if ( note.id !== undefined) {
      if(!this.props.newTag) {
        return (
            <span>
            Create new tag:
            <i
                className="tag-button material-icons"
                onClick={() => this.props.showTagForm()}
            >
              add circle
            </i>
          </span>
        );
      } else {
        return (
            <form onSubmit={(e) => this.onTagSubmit(e)}>
              <input
                  className="tag-input"
                  type="text"
                  placeholder="Tag Name..."
                  ref={(input) => this.name = input}
              />
            </form>
        );
      }
    }
  }

  renderTags (note) {
    if (note.tags) {
      return note.tags.map((tag, index) =>
          <div
              className="tag"
              key={index}
              onClick={(e) => this.props.deleteTag(note.id, tag.id)}
          >
          <span className="delete">
            <i className="material-icons">delete</i>
          </span>
            {tag.name}
          </div>
      );
    }
  }

  setTagsToAdd = (e) => {
    this.state.tagsToAdd.push(document.getElementById("sel1").value);
  }

  render() {
    const { note, closeTagForm } = this.props;
    return(
      <div className="note-container">
        <form
          className="note-form"
          onSubmit={(e) => this.onSubmit(e)}
          onClick={() => closeTagForm()}
        >
          <div className="note-title">
            <input
              className="note-title-input"
              type="text"
              placeholder="Note Title..."
              defaultValue={note.title}
              ref={(input) => this.title = input}
            />
          </div>
          <div className="note-textarea-container">
            <textarea
              className="note-textarea"
              placeholder="Type Here..."
              defaultValue={note.content}
              ref={(input) => this.content = input}
            />
            <br/><br/><br/>
            <div className='form-group' id='select-form'>
              <select className='form-control' id='sel1'>
                {
                  this.state.tags.map(tag => <option key={tag.id}>{tag.name}</option>)
                }
              </select>
              <input className="note-button" type="submit" value="Submit" onClick={this.setTagsToAdd}/>

            </div>
          </div>


        </form>

        <div className="tag-container">
          <div className="tag-button-container">
            {this.renderTagForm(note)}
          </div>
          <div className="tag-list-container">
            {this.renderTags(note)}
          </div>
        </div>
      </div>
    );
  }
}

export default Note;