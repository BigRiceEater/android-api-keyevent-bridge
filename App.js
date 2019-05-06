import React, {Component} from 'react';
import {StyleSheet, View, Button, NativeModules } from 'react-native';
import {DeviceEventEmitter } from 'react-native'

export default class App extends Component {
  
  componentDidMount(){
    this.subscription = DeviceEventEmitter.addListener('onKeyDown', (event) => {
      console.log(event)
    })
  }

  render() {
    return (
      <View style={styles.container}>
        <Button title="Show Toast" onPress={ () => NativeModules.ReactKeyEvent.alert('Toasting 1 2 3') } /> 
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  }
});