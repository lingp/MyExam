import React from 'react'
import Item from "./Item";
import PropTypes from "prop-types";
import store from "../store";

class List extends React.Component{
    constructor(props){
        super(props);
        // 1.获取redux中的数据
        this.state = store.getState();
        // 2.订阅store的改变
        this._handleStoreChange = this._handleStoreChange.bind(this);
        store.subscribe(this._handleStoreChange);
    }
    static propTypes = {
        datas: PropTypes.array.isRequired, // 数据
        changeFinished: PropTypes.func.isRequired, //选中一条记录
        delById: PropTypes.func.isRequired, // 删除一条记录
    };
    render(){
        const {datas, changeFinished, delById} = this.props;
        const storeDatas = this.state.datas;

        return (
            <ul className="todo-main">
                {
                    storeDatas.map((data, index)=>(
                        <Item
                            key={index}
                            data={data}
                            changeFinished = {changeFinished}
                            delById = {delById}
                        />
                    ))
                }
            </ul>
        )
    }

    _handleStoreChange(){
        // 3.更新状态
        this.setState(store.getState())
    }
}

export  default  List;