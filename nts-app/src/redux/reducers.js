import { SET_ACTIVE_COMPONENT } from './actions';

const initialState = {
    activeComponent: 'Home', // Početna komponenta
};

const appReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_ACTIVE_COMPONENT:
            return { ...state, activeComponent: action.payload };
        default:
            return state;
    }
};

export default appReducer;
