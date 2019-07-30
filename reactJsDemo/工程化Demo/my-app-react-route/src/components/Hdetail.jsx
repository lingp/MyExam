import React, {Component} from 'react';
import url from 'url';


class Hdetail extends Component {
    constructor(props){
        super(props);
        this.state = {};
    }

    render(){
        return (
            <div style={{backgroudColor: 'yellow'}}>
                hello world
            </div>
        )
    }

    componentDidMount(){
        console.log(this.props);
        console.log(url.parse(this.props.location.search,true).query);
        let t = url.parse(this.props.location.search,true).query;
        console.log(t.lid);
    }
}

export default Hdetail;