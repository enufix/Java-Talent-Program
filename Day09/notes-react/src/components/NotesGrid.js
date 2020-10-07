import React, { Component } from 'react';
import NoteCard from './NoteCard';

class NotesGrid extends Component {
  componentDidMount() {
    this.props.getNotes();
  }

  render() {
    const { notes, getNote, deleteNote } = this.props;

    const cards = notes.map((note, index) => {
      return (
        <NoteCard
          key={index}
          index={index}
          note={note}
          getNote={getNote}
          deleteNote={deleteNote}
        />
      );
    });

    return (
      <div className="list-container">
        {cards}
      </div>
    );
  }
}

export default NotesGrid;