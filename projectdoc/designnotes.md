This is a link to [[WikiLink]]

Design Overview
===============
*  Codex is a collection of Notes
*  Notes have NoteViews.  NoteViews are the editor.
*  NotesController is the overall view.  Can add, maximize, hide, layout.  Also has the Menu and the 
   lists of Notes and NoteViews.
*  There are Scripts.  Scripts are Groovy and have access to Current Note, Current NoteView, NotesController.
*  There are StyleSheets.  Used to export Notes.
*  Some Notes are Images.  Images have Metadata (Can be OCR'ed)
*  Notes have Links to other Notes.

Movements
---------
*   F3 - open link.  If [[]] - go to note.  If image, open image.  If filepath,
    open in explorer.  Otherwise, open as browser link
*   Movement stack - ctrl-o/alt-backspace = down stack,
    ctrl-<????>/alt-shift-backspace = up stack
*   ctrl-f search
*   ctrl-i incremental search?  maybe ctrl-j to match eclipse

Insert path
-----------
*   Open file browser
*   Ctrl-X-F like behavior too
*   `shellslash` behavior?  Quick convert keypress or function?

On Save
--------
*   Find TODO, [ ]
*   Parse #hashtags, @date
*   OCR for images

NoteView types
--------------
*  TableView
*  MarkdownView
*  ImageView
*  PieChartView
*  EncryptedView?
*  CredentialsView (ssh or pem keys)
*  GroovyView

Other Views
-----------
*  CalendarView
*  SearchView
*  ImageBrowser

NoteView commands
*  makeTitle
*  makeList
*  makeTable
*  sumTableColumn
*  sortTable
*  sortList
*  updateListNumbering
*  insertImage
*  selectSection

NotesController commands
*  runScript
*  emailNotes
*  gitExportNotes
*  gitImportNotes
*  publishNotes
*  httpServeNotes
*  runScript
*  runSsh
*  openLink

```
View
------------------------------------|
| Section/Name                      |
| Created: yyyymmdd Edited yyyymmdd |
------------------------------------|
|                                   |
|  Content                          |
|                                   |
------------------------------------|
```

Third Party Stuff
-----------------
Parser
: https://jflex.de/manual.html

Markdown Parser
: https://github.com/atlassian/commonmark-java

Better Markdown Parser
: https://github.com/vsch/flexmark-java

Editor Widget
: https://github.com/bobbylight/rsyntaxtextarea/wiki

Export to Word
: https://www.docx4java.org/trac/docx4j

Export to PDF
: https://github.com/danfickle/openhtmltopdf

# Links

[[WikiLink]]

Tasks
-----

| Task Number | Task                                         | Done |
| ----------- | -------------------------------------        | ---- |
| A0001       | Database                                     |      |
| A0002       | Markdown Editor for notes in database        |      |
| A0003       | New note                                     |      |
| A0004       | Open note in current editor                  |      |
| A0005       | Next/Previous                                |      |
| A0006       | Undo/Redo                                    |      |
| A0007       | Search                                       |      |
| A0008       | Delete note                                  |      |
| A0009       | New editor window                            |      |
| A0010       | Insert Image                                 |      |
| A0011       | Cleanup unlinked windows                     |      |
| A0012       | Insert link                                  |      |
| A0013       | Syntax highlighting                          |      |
| A0014       | Preview window                               |      |
| A0015       | Open wikilink                                |      |
| A0016       | Open hyperlink                               |      |
| A0018       | Select element. Expand/Move/Narrow selection |      |
| A0019       | Run selection (filter, add below, no output) |      |
| A0020       | Read selection as HTML                       |      |
| A0021       | Read selection as JSON / Gron                |      |
| B0001       | Image browser                                |      |
| B0002       | Image metadata editor                        |      |
| B0003       | OCR integration                              |      |
| C0001       | Export to filesystem                         |      |
| C0002       | Export to html                               |      |
| C0003       | Export to pdf                                |      |
| C0004       | Export to word                               |      |
| C0005       | Export to email                              |      |
| C0006       | Backup notes                                 |      |
| C0007       | Import/Transfer notes                        |      |
| D0001       | Search View                                  |      |
| D0002       | Hashtag search                               |      |
| D0003       | TODO and TODO Search                         |      |
| E0001       | Calendar View                                |      |
| E0002       | Colored tags in calendar view                |      |
| E0003       | List of notes on same day in calendar view   |      |
| F0001       | Note heirarchy browser                       |      |
| F0002       | Move notes in heirarchy                      |      |
| G0001       | Insert table                                 |      |
| G0002       | Format table                                 |      |
| G0003       | Sort table                                   |      |
