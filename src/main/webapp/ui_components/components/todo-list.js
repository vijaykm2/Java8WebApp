import React, {PropTypes} from 'react';
import Todo from './todo';

const TodoList = ({todos, onToDoClick}) => {
  debugger;
    return (todos && todos.length >0 ? (<ul>
        {todos.map(todo =>
      <Todo
        key={todo.id}
        {...todo}
        onClick={() => onTodoClick(todo.id)}
      />
    )}
    </ul>) : (<p> List is empty </p>));
}



TodoList.propTypes = {
    todos : PropTypes.arrayOf( PropTypes.shape({
        id: PropTypes.number.isRequired,
        completed: PropTypes.bool.isRequired,
        text: PropTypes.string.isRequired
    }).isRequired).isRequired,
    onToDoClick: PropTypes.func.isRequired
}

export default TodoList;
