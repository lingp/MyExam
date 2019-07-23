import {CHANGE_FINISHED, DEL_ONE, GET_ALL_DATAS} from './actionTypes'


// 默认数据
const defaultState = {
    datas : [],
    count : 0
};


export default (state = defaultState, action)=>{
    const newState = JSON.parse(JSON.stringify(state));
    // 1. 获取所有的数据
    if(action.type == GET_ALL_DATAS){
        newState.datas = action.datas;
        return newState;
    }
    // 修改一条记录的状态
    if(action.type == CHANGE_FINISHED){
        let count = 0;
        newState.datas.forEach((data, index)=>{
            if(data.id == action.id){
                data.isFinished = action.isFinished;
            }
            if(data.isFinished){
                count += 1;
            }
        });

        newState.count = count;
        return newState;
    }
    // 删除一条记录
    if(action.type == DEL_ONE){
        let tmpDatas = [];
        let tmpCount = 0;
        newState.datas.forEach((data, index)=>{
            if(data.id !=  action.id){
                tmpDatas.push(data);
                tmpCount += (data.isFinished ? 1 : 0);
            }
        });
        newState.datas = tmpDatas;
        newState.count = tmpCount;
        return newState;
    }

    return state;
}