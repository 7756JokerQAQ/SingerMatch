import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import axios from "axios";
import styleImport, {VantResolve} from 'vite-plugin-style-import';

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue(), styleImport({
        resolves: [VantResolve()],
    }),],

    // server: {
    //     host:'http://101.43.134.210'
    // }
})




