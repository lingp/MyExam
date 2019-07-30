import React, {Component} from 'react';
import {Redirect} from 'react-router-dom';


class Login extends Component {
    constructor(props){
        super(props);
        this.state = {
            loginFlag : false //登录状态
        }
    }

    render(){
        if(this.state.loginFlag){
            return <Redirect to="/" />
        }
        return (
            <div style={{backgroundColor: 'red'}}>
                <p></p>
                <p></p>
                <p></p>
                <form onSubmit={(e)=>this._dealLogin(e)}>
                    <input type="text" ref="username" />
                    <br />
                    <input type="password" ref="password"/>
                    <br />
                    <input type="submit" value="登录" />
                </form>
            </div>
        )
    }

    _dealLogin(e){
        const username =  this.refs.username.value;
        const password = this.refs.password.value;
        console.log(username,password);

        if(username === 'test' && password == 'test'){
            this.setState({
                loginFlag:true
            })
        }else{
            alert('登录失败');
        }

    }

}

export  default Login;