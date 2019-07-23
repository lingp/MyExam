import React from 'react'
import PropTypes from "prop-types";


class Footer extends React.Component{
    constructor(props) {
        super(props);
    }
    static propTypes = {
        count: PropTypes.number.isRequired, // 单条数据
        delAllFinished: PropTypes.func.isRequired, // 删除已完成的任务，
        allFinished: PropTypes.func.isRequired // 全选
    };
    render(){
        const {count,totalCount, delAllFinished, allFinished} = this.props;
        return (
            <div className="todo-footer">
                <label>
                    <input type="checkbox"  checked={count ===  totalCount} onChange={()=>allFinished(count !== totalCount)}/>
                </label>
                <span>
                      <span>已完成{count}件</span> / 总计{totalCount}件
                   </span>
                <button className="btn btn-warning" onClick={()=>delAllFinished()}>清除已完成任务</button>
            </div>
        )
    }
}

export  default  Footer;