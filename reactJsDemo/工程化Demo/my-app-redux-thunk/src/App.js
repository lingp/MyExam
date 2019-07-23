import React from 'react';
import './App.css';
import Header from  './compenents/Header';
import List from "./compenents/List";
import Footer from './compenents/Footer';
import {getDatas} from "./api";
import {initDatas} from './store/actionCreators';
import store from "./store";

class App extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            datas : [
                {id:1, title:'学习一小时', isFinished: false},
                {id:2, title:'运动一小时', isFinished: false},
                {id:3, title:'休息一小时', isFinished: false}
            ],
            count: 0
        }
    }

    // 不使用redux的情况
   // async _reqDatas(){
   //      const result = await getDatas();
   //      if(result.success_code == 200){
   //          this.setState({
   //              datas: result.items
   //          })
   //      }
   //  }
   //
   //  componentDidMount() {
   //      // 初始化获取所有数据
   //      this._reqDatas();
   //  }

    // 使用redux的情况
    componentDidMount(){
        const action = initDatas();
        store.dispatch(action);
    }



    // 1.修改选中状态
    changeFinished = (id, isFinished) => {
        //1.1 遍历
        const tmpDatas = this.state.datas;
        let count = 0;
        tmpDatas.forEach((data, index) => {
            if (data.id === id) {
                data.isFinished = isFinished; // 1.2 改变状态
            }
            if (data.isFinished) {
                count += 1; // 1.3 计算总和
            }
        });
        //1.4 改变状态,注意，这里要是setState
        this.setState({
            datas: tmpDatas,
            count: count
        })
    };

    // 2.删除一条记录
    delById = (id) => {
        //2.1 遍历
        const tmpDatas = this.state.datas;
        let tmpCount = 0;
        let newDatas = [];
        tmpDatas.forEach((data, index)=>{
            // splice会改变原数组，这种写法有问题，
            // 参考https://blog.csdn.net/suimoshi/article/details/87897664
            // if(data.id === id){
            //     tmpDatas.splice(index, 1);
            // } else if(data.isFinished){
            //     tmpCount += 1;
            // }
            if(data.id != id){
              newDatas.push(data);
              tmpCount += (data.isFinished ? 1 : 0);
            }
        });
        this.setState({
            datas: newDatas,
            count: tmpCount
        })
    };

   // 3.添加一条新纪录
    addNewOne = (data) => {
      // 3.1 取出数组
      let tmpDatas = this.state.datas;
      // 3.2 push
      tmpDatas.push(data);
      //3.3 更新状态
      this.setState({
          datas: tmpDatas
      })
    };

    // 4.删除已经完成的所有任务
    delAllFinished = () => {
        let newDatas = [];
        const tmpDatas = this.state.datas;
        tmpDatas.forEach((data, index)=>{
            if(!data.isFinished){
                newDatas.push(data);
            }
        });

        this.setState({
            datas: newDatas,
            count: 0
        })
    };

    allFinished = (flag)=>{
        const tmpDatas = this.state.datas;
        let count = 0;
        if(flag){
            tmpDatas.forEach((data, index)=>{
                data.isFinished = true;
            })
            count = tmpDatas.length;
        } else {
            tmpDatas.forEach((data, index)=>{
                data.isFinished = false;
            })
        }
        this.setState({
           datas: tmpDatas,
            count: count
        });
    };

    render() {
      const {datas, count} = this.state;
        return (
            <div className="todo-container">
                <div className="todo-wrap">
                    <Header
                        lastDataId={datas.length == 0 ? 0 : datas[datas.length-1].id}
                        addNewOne={this.addNewOne}
                    />
                    <List datas={datas} changeFinished={this.changeFinished} delById={this.delById} />
                    <Footer count={count} totalCount={datas.length} delAllFinished={this.delAllFinished} allFinished={this.allFinished}/>
                </div>
            </div>
        );
    }




}

export default App;
