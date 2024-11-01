export const SET_ACTIVE_COMPONENT = 'SET_ACTIVE_COMPONENT';

export const setActiveComponent = (componentName) => ({
    type: SET_ACTIVE_COMPONENT,
    payload: componentName,
});