import React from 'react'
import Footer from './footer'
import AddTodo from './containers/AddTodo'
import VisibleTodoList from './containers/VisibleTodoList'

const App = () => (
  <div>
    {document.write("It works.")}
    {document.write("Hello wdfsdfasdfaasfkskdksadorld")}
    <AddTodo />
    <VisibleTodoList />
    <Footer />
  </div>
)

export default App;
