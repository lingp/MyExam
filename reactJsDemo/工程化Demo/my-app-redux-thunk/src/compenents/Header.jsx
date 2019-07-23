import React from 'react';
import PropTypes from "prop-types";


class Header extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            content:''
        }
    }
    static propTypes = {
        addNewOne: PropTypes.func.isRequired
    };
    render(){
        const {lastDataId, addNewOne} = this.props
        return (
            <div className="todo-header">
                <input type="text" placeholder="请输入今天的任务清单，按回车键确认"
                       value={this.state.content}
                       onChange={(e)=>this._inputData(e)}
                       onKeyDown={(e)=>this._addNewData(e)}
                />
            </div>
        )
    }

    _inputData(e){
        const content = e.target.value;
        this.setState({
            content: content
        });
    }

    _addNewData(e){
        const {lastDataId, addNewOne} = this.props;
        // 1.判断是否为回车键
        if(13 == e.keyCode){
            // 2.判断输入的内容是否为空
            const content = this.state.content;
            if(content == ''){
                alert('输入内容为空！');
                return false;
            }
            // 3.创建data对象
            const data = {id:lastDataId, title: content, isFinished: false};
            addNewOne(data);
            // 4.清空内容
            this.setState({
                content: ''
            })
        }
    }


}

export  default Header;

