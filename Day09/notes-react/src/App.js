import React, { Component } from 'react';
import './App.css';
import Nav from './components/Nav';
import NotesGrid from './components/NotesGrid';
import Note from './components/Note';
import axios from 'axios';


class App extends Component {
  constructor() {
    super();
    this.state = {
      showNote: false,
      notes: [],
      tags: [],
      note: {},
      newTag: false,
      error: ''
    };
  }

  toggleNote = () => {
    this.setState({
      showNote: ! this.state.showNote,
      note: {}
    })
  }


  getNotes = () => {
    axios.get(('/api/notes'))
        .then((res) => this.setState({notes: res.data}) )
        .catch((err) => console.log(err.response.data) );
  }


  getNote = (id) => {
    axios.get((`/api/notes/${id}`))
        .then((res) => this.setState({note: res.data, showNote: true }) )
        .catch((err) => console.log(err.response.data) );
  }

  performSubmissionRequest = (data, id) => {
    if (id) {
      return axios.put((`/api/notes/${id}`), data);
    } else {
      return axios.post(('/api/notes'), data);
    }
  }

  submitNote = (data, id) => {
    this.performSubmissionRequest(data, id)
        .then((res) => this.setState({ showNote: false }) )
  }

  deleteNote = (id) => {
    const newNotesState = this.state.notes.filter((note) => note.id !== id );
    axios.delete((`/api/notes/${id}`) )
        .then((res) => this.setState({ notes: newNotesState }) )
        .catch((err) => console.log(err.response.data) );
  }

  showTagForm = () => {
    this.setState({ newTag: true });
  }

  closeTagForm = () => {
    this.setState({ newTag: false });
  }

  submitTag = (data, id) => {
    axios.post((`/api/tags/`), data)
        .then((res) => this.getNote(id) )
  }

  deleteTag = (noteId, id) => {
    axios.delete((`/api/tags/${id}`))
        .then((res) => this.getNote(noteId) )
        .catch((err) => console.log(err.response.body))
  }


  render() {
    const { showNote, notes, note, newTag } = this.state;

    return (
        <div className="App">
          <Nav toggleNote={this.toggleNote} showNote={showNote} />
          <br />
          { showNote ?
              <Note
                  note={note}
                  newTag={newTag}
                  submitNote={this.submitNote}
                  showTagForm={this.showTagForm}
                  closeTagForm={this.closeTagForm}
                  submitTag={this.submitTag}
                  deleteTag={this.deleteTag}
              />
              :
              <NotesGrid
                  getNotes={this.getNotes}
                  notes={notes}
                  getNote={this.getNote}
                  deleteNote={this.deleteNote}
              /> }
        </div>
    );
  }

}

export default App;
