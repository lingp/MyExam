import React, {Component} from 'react';
import {Link} from "react-router-dom";


class Follow extends Component {

    constructor(props){
        super(props);
        this.state = {};
    }

    render(){
        return (
            <div style={{backgroudColor:'green'}}>
                关注版块
                <p></p>
                <button>
                    <Link to="/login"> 关注一下</Link>
                </button>
            </div>
        )
    }
}

export default Follow;