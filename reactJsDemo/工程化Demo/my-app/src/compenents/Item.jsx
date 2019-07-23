import React from 'react'
import PropTypes from 'prop-types';

class Item extends React.Component {
    constructor(props){
        super(props);

        this.state = {
            showDelBtn: false
        }

    }
    static propTypes = {
        data: PropTypes.object.isRequired, // 单条数据
        changeFinished: PropTypes.func.isRequired, //选中一条记录
        delById: PropTypes.func.isRequired, // 删除一条记录
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
                    <input type="checkbox" checked={data.isFinished} onChange={()=>changeFinished(data.id, !data.isFinished)}/>
                    <span>{data.title}</span>
                </label>
                <button className="btn btn-warning"
                        style={{display: showDelBtn ? "block" : "none"}}
                        onClick={()=>delById(data.id)}
                >删除</button>
            </li>
        )
    }

    _showDelBtn(flag){
        this.setState({
            showDelBtn: flag
        })
    }


}

export default Item;