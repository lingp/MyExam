import React from 'react'
import Item from "./Item";
import PropTypes from "prop-types";

class List extends React.Component{
    constructor(props){
        super(props);
    }
    static propTypes = {
        datas: PropTypes.array.isRequired, // 数据
        changeFinished: PropTypes.func.isRequired, //选中一条记录
        delById: PropTypes.func.isRequired, // 删除一条记录
    };
    render(){
        const {datas, changeFinished, delById} = this.props;
        return (
            <ul className="todo-main">
                {
                    datas.map((data, index)=>(
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
}

export  default  List;