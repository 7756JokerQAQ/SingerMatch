<template>
  <template v-if="user">
    <van-cell title="当前用户" :value="user?.username"/>
    <van-cell title="修改信息" is-link to="/user/update"/>
    <van-cell title="我创建的队伍" is-link to="/user/team/create"/>
    <van-cell title="我加入的队伍" is-link to="/user/team/join"/>
  </template>
  <van-form @submit="onLogout">
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        退出登录
      </van-button>
    </div>
  </van-form>
</template>

<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import myAxios from "../plugins/myAxios";
import {Toast} from "vant";
import {getCurrentUser} from "../services/user";

const route = useRoute();

const user = ref();


const router = useRouter();

onMounted(async () => {
  user.value = await getCurrentUser();
})
const toEdit = (editKey: string, editName: string, currentValue: string) => {
  router.push({
    path: '/user/edit',
    query: {
      editKey,
      editName,
      currentValue,
    }
  })
}

const onLogout = async () => {
  const res = await myAxios.post('/user/logout')
  console.log("用户注销");
  if (res.code === 0 && res.data) {
    Toast.success('注销成功');
    const redirectUrl = route.query?.redirect as string ?? '/user/login';
    window.location.href = redirectUrl;
  } else {
    Toast.fail('退出失败')
  }
}

</script>

<style scoped>

</style>