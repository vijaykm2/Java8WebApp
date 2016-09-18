import React, {PropTypes} from 'react';
import Todo from './todo';

const TodoList = ({todos, onToDoClick}) => {
    <ul>
        {
            todos.map(todo =>
                key = {todo.id}
                {...todo}
                onClick : {() => onToDoClick(todo.id)}
            )
        }
    </ul>
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