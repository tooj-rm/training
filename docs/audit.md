The Audit project is an audit system that keeps track of all visitors in an organization. It :

- uses flat text files as underlying storage with the structure shown below
- system appends the visitor’s name and the time of their visit to the end of the most recent file
- When the maximum number of entries per file is reached: a new file with an incremented index is created