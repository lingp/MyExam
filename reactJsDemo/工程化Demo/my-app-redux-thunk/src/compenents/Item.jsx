import React from 'react'
import PropTypes from 'prop-types';
import {changeFinished, delOne} from "../store/actionCreators";
import store from "../store";

class Item extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            showDelBtn: false
        };
        this._changeFinished = this._changeFinished.bind(this);
    }
    static propTypes = {
        data: PropTypes.object.isRequired, // 单条数据
    };

    render(){
        const {data, changeFinished, delById} = this.props;
        const {showDelBtn} = this.state;
        return (
            <li
                onMouseOver={()=>this._showDelBtn(true)}
                onMouseOut={()=>this._showDelBtn(false)}
            >
                <label>
                    <input type="checkbox"
                           checked={data.isFinished}
                           onChange={(e)=>this._changeFinished(data.id, !data.isFinished)}/>
                    <span>{data.title}</span>
                </label>
                <button className="btn btn-warning"
                        style={{display: showDelBtn ? "block" : "none"}}
                        onClick={(event)=>this._delOne(data.id)}
                >删除</button>
            </li>
        )
    }

    // 处理按钮是否显示
    _showDelBtn(flag){
        this.setState({
            showDelBtn: flag
        })
    }

    // 修改选中状态
    _changeFinished(id, isFinished){
        const action = changeFinished(id, isFinished);
        store.dispatch(action);
    }

    // 删除
    _delOne(id){
        const action = delOne(id);
        store.dispatch(action);
    }

}

export default Item;