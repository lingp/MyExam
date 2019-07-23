import React from 'react'
import PropTypes from "prop-types";
import store from "../store";


class Footer extends React.Component{
    constructor(props) {
        super(props);
        this.state = store.getState();

        // 订阅store的改变
        this._handleStoreChange = this._handleStoreChange.bind(this);
        store.subscribe(this._handleStoreChange);
    }
    static propTypes = {
        count: PropTypes.number.isRequired, // 单条数据
        delAllFinished: PropTypes.func.isRequired, // 删除已完成的任务，
        allFinished: PropTypes.func.isRequired // 全选
    };
    render(){
        const {count,totalCount, delAllFinished, allFinished} = this.props;
        console.log(this.state);
        return (
            <div className="todo-footer">
                <label>
                    <input type="checkbox"  checked={count ===  totalCount} onChange={()=>allFinished(count !== totalCount)}/>
                </label>
                <span>
                      <span>已完成{this.state.count}件</span> / 总计{this.state.datas.length}件
                   </span>
                <button className="btn btn-warning" onClick={()=>delAllFinished()}>清除已完成任务</button>
            </div>
        )
    }

    _handleStoreChange(){
        this.setState(store.getState())
    }
}

export  default  Footer;